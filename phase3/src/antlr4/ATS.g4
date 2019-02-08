grammar ATS;

@header
{
    import java.awt.geom.Point2D;
    import java.time.LocalDate;
    import java.util.concurrent.ThreadLocalRandom;
    import java.util.*;
}

@members
{
    UMeR umer;
    Client client;
    Driver driver;
    User user;
    String key;
    String cla;
    Point2D.Double start = new Point2D.Double();
    int contadormatriculas = 1;
    int viagens = 0;
    int logins = 0;
    int condutor=0;
    int clientes = 0;
    int empresas=0;
    int logout=0;
    int recusadas = 0;

    int veic = 0;
    Vehicle car;
    Trip trip;
    ArrayList<Trip> viagensSolicitadas = new ArrayList<Trip>();
    int contadorfinal;

    private String unquote(String str) {
      if (str == null) return null;
      else {
        return str.substring(1,str.length()-1);
      }
    }

    private Trip viajar(String key) {
        Trip remover = null;
        int stop = 0;

        for (Trip object: viagensSolicitadas) {
            if ((object.getDriver().equals(key)) && stop == 0) {
                remover = object;
                stop = 1;
            }
        }

        Boolean res = viagensSolicitadas.remove(remover);
        return remover;
    }

    private Trip viajarQualquer() {
        Trip remover = null;
        int tam = viagensSolicitadas.size();

        if (tam > 0){
            remover= viagensSolicitadas.remove(tam-1);
        }

        return remover;
    }
}

/**
 *
 * REGRAS
 *
 */

actions 
@after {
	System.out.println("-------------------------------");
	System.out.println("| Logins realizados:      " + logins + " |");
	System.out.println("| Clientes registados:    " + clientes + " |");
	System.out.println("| Condutores registados:  " + condutor + " |");
	System.out.println("| Empresas registadas:    " + empresas + "   |");
	System.out.println("| Veiculos registados:    " + veic + " |");
	System.out.println("| Viagens Solicitadas:    " + contadorfinal + " |");
	System.out.println("| Viagens recusadas:      " + recusadas + " |");
	System.out.println("| Viagens realizadas:     " + viagens  + " |");
	System.out.println("| Logouts realizados:     " + logout + " |");
	System.out.println("| Viagens retidas:        " +  viagensSolicitadas.size() + "   |");
	System.out.println("-------------------------------"  );

    try {
        umer.saveUMeR("umerData-tests");
    } catch (Exception e) {
        System.out.println("ERRO! : " + e);
    }
}
		: (action ';')+ EOF
;

action : registo
       | login
       | logout
       | recusar
       | solicitar
       | viajar

;

registo : registarCondutor
        | registarCliente
        | registarEmpresa
        | registarVeiculo
        | registarVeiculoEmpresa
;

registarCondutor : 'registar condutor' email=STRING name=STRING pass=STRING rua=STRING dat=DATA comp=NUM
{
    LocalDate localDate = LocalDate.parse($dat.text);
    double value = Double.parseDouble($comp.text);
    String company = null;
    driver = new Driver(unquote($email.text),unquote($name.text),unquote($pass.text),unquote($rua.text),localDate,value,unquote(company));

    // Criar veiculo aletorio
    String plate  = String.valueOf(contadormatriculas); contadormatriculas++;
    Double reliable = ThreadLocalRandom.current().nextDouble(0, 100);
    Point2D.Double position = new Point2D.Double(ThreadLocalRandom.current().nextDouble(0, 100), ThreadLocalRandom.current().nextDouble(0, 100));
    Vehicle carro = new Car(plate, reliable, position,unquote($email.text));
    umer.registerVehicleP(carro);
   
    // Registar veiculo no condutor
    driver.setVehicle(plate);
    boolean regista = umer.registerUser(driver,company);
    condutor++;

}
| 'registar condutor' email=STRING name=STRING pass=STRING rua=STRING dat=DATA comp=NUM emp=STRING
{
    LocalDate localDate = LocalDate.parse($dat.text);
    double value = Double.parseDouble($comp.text);
    String company = unquote($emp.text);
    driver = new Driver(unquote($email.text),unquote($name.text),unquote($pass.text),unquote($rua.text),localDate,value,company);
    // boolean regista = umer.registerUser(driver,company);

    //Criar veiculo aletorio
    String plate  = String.valueOf(contadormatriculas); contadormatriculas++;
    Double reliable = ThreadLocalRandom.current().nextDouble(0, 100);
    Point2D.Double position = new Point2D.Double(ThreadLocalRandom.current().nextDouble(0, 100), ThreadLocalRandom.current().nextDouble(0, 100));
    Vehicle carro = new Car(plate, reliable, position,unquote($email.text));
    umer.registerVehicleP(carro);


    //registar veiculo condutor_
    driver.setVehicle(plate);
    boolean regista = umer.registerUser(driver, company);
    condutor++;
}
;

registarCliente : 'registar cliente' email=STRING name=STRING pass=STRING rua=STRING dat=DATA p=posicao
{
    LocalDate localDate = LocalDate.parse($dat.text);
    Point2D.Double ponto = $p.pos;
    client = new Client(unquote($email.text),unquote($name.text),unquote($pass.text),unquote($rua.text), localDate);
    client.setPosition(ponto);
    boolean regista = umer.registerUser(client, null);
    clientes++;
}
;

registarEmpresa : 'registar empresa' nome=STRING pass=STRING
{
    boolean regista = umer.registerCompany(unquote($nome.text), unquote($pass.text));
    empresas++;
    
}
;

registarVeiculo : 'registar' tipo=VEICULO matricula=STRING rel=NUM pos=posicao emailOwner=STRING
{
  String veiculo = unquote($matricula.text);
  String empresa = unquote($emailOwner.text);
    Point2D.Double ponto = $pos.pos;
    Vehicle v = null;
    switch ($tipo.text) {
		case "carro":
			v = new Car(veiculo, Double.parseDouble($rel.text), ponto, empresa);
           	break;
		case "mota":
			v = new Bike(veiculo, Double.parseDouble($rel.text), ponto, empresa);
            break;
		case "carrinha":
			v =  new Van(veiculo, Double.parseDouble($rel.text), ponto, empresa);
           	break;
		case "helicoptero":
			v = new Helicopter(veiculo, Double.parseDouble($rel.text), ponto, empresa);
            break;
		default:
            System.out.println("ERROs");
            
        
	}
    veic++;

	// Buscar o condutor e eliminar veiculo atual
	Driver d = umer.getAllDrivers().get(empresa);
	Vehicle ve = umer.getAllVehicles().get(d.getVehicle());
	umer.removeVehicle(ve);

	// Adicionar o novo e muda o condutor
	boolean regista =  umer.registerVehicleP(v);
	umer.changeDriverVehicle(empresa, veiculo);

	if (regista == false)
		System.out.println("Problema ao registar Veiculo");
}
;


registarVeiculoEmpresa : 'registar' tipo=VEICULO matricula=STRING rel=NUM pos=posicao 'empresa' empresa=STRING
{

  	String veiculo = unquote($matricula.text);
  	String empresa = unquote($empresa.text);
    Point2D.Double ponto = $pos.pos;
    Vehicle v = null;
    switch ($tipo.text) {
		         case "carro":
			         v = new Car(veiculo, Double.parseDouble($rel.text), ponto, empresa);
           	         break;
		         case "mota":
			         v = new Bike(veiculo, Double.parseDouble($rel.text), ponto, empresa);
                     break;
		         case "carrinha":
			         v =  new Van(veiculo, Double.parseDouble($rel.text), ponto, empresa);
           	         break;
		         case "helicoptero":
			         v = new Helicopter(veiculo, Double.parseDouble($rel.text), ponto, empresa);
                     break;
		         default:
                 	System.out.println("ERROs");
	}

	// Regista veiculo
	boolean regista = umer.registerCompanyVehicle(empresa, v);
    veic++;
	if (regista == false)
		System.out.println("Problema ao registar Veiculo");
}
;


login : 'login' nome=STRING pass=STRING
{
    User user = umer.allUsers().get(unquote($nome.text));
    if (user != null && user.getPassword().equals(unquote($pass.text))) {
        key =unquote($nome.text) ;
        logins++;
    }
    else {
        Company company = umer.getCompanies().get(key);
        if (company != null && company.getPassword().equals(unquote($pass.text))) {
            key =unquote($nome.text) ;
            logins++;
        }
    }
    if (unquote($nome.text).equals("admin") && (unquote($pass.text)).equals("12345")){
        key = "admin";

    }

}

;


solicitar : 'solicitar' pos=posicao
{
    Point2D.Double ponto = $pos.pos;
    Client client = umer.getClients().get(key);
    Trip trip = umer.newTripClosest(client, ponto);

    if (trip == null) {
        System.out.println("A VIAGEM VEIO VAZIA");
    } else {
        contadorfinal++;
        viagensSolicitadas.add(trip);
       
    }
}
;

viajar : 'viajar'
{
    if (key != null) {
        Trip vTemp = viajarQualquer();

        if (vTemp == null) {
            //System.out.println("Nao conseguiu viajar, nao tinha viagens!");
        } else {
            Client c = umer.getClients().get(vTemp.getClient());
            Driver d = umer.getAllDrivers().get(key);

            if (d == null) System.out.println("condutor esta null");

            String matricula = d.getVehicle();
            Vehicle v = umer.getAllVehicles().get(matricula);

            Trip vfinal  = umer.newTrip(c,d,v,vTemp.getEnd());

            int randomRating = (int)(Math.random() * 5 + 1);
           
            try{

                umer.addTrip(vfinal.getClient(), vfinal.getDriver(), vfinal.getLicencePlate(), vfinal);
                viagens++;
                //umer.addRating(vfinal.getDriver(),randomRating,vfinal.getID());
            }catch(Exception e) {System.out.println("Company null");}
            
       }   
}
}
;

recusar : 'recusar viagem'
{
    int numA = viagensSolicitadas.size();
    Trip viajar = viajarQualquer();
    int numD = viagensSolicitadas.size();

    if (viajar != null) {
        //System.out.println("Viagem removida com sucesso;");
        recusadas++;
    } else {
        //System.out.println("Nao conseguiu remover, nao tinha viagens!");
    }
}
;

logout : 'logout'
{
    key = null;
    logout++;

}
;

posicao returns [Point2D.Double pos] : '(' prim=DECIMAL ',' seg=DECIMAL')'
{
    Point2D.Double po = new Point2D.Double();
    po.setLocation(Double.parseDouble($prim.text), Double.parseDouble($seg.text));
    $pos = po;
}
;


/*
 *
 * TOKENS
 *
 */

VEICULO : [A-Za-z]+ ;

/* Uma String entre aspas */
STRING : '"' (~[\\"] | '\\' [\\"])* '"' ;

/* Data no formato YYYY-MM-DD */
DATA : DIGIT DIGIT DIGIT DIGIT '-' DIGIT? DIGIT '-' DIGIT? DIGIT ;

/* Dígito */
DIGIT : [0-9] ;

NUM : [0-9]*;

DECIMAL : [0-9]+('.'[0-9]+)?;

/* Espaço em branco (que é ignorado) */
WS : [ \t\r\n]+ -> skip ;
