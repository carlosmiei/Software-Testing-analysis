.PHONY : default compile run

default :
	@printf "\
Use um dos seguintes comandos:\n\
  *** Genéricos ***\n\
    compile   (projecto de ATS)\n\
    run       (projecto de ATS)\n\
    clean     (geral; remove a directoria 'target')\n\
  *** Projecto ATS ***\n\
    ats-gen\n\
    ats-compile\n\
    ats-run\n\
  *** Projecto UMeR ***\n\
    umer-compile\n\
    umer-run\n\
Ver makefile para documentação sobre os mesmos.\n"

compile : ats-compile

run : ats-run

# remove todos os artefactos de compilação
clean :
	@echo rm -r target
	@if [ -d target ] ; then rm -r target ; fi

#
# UMeR
#

### variáveis

CLASSPATH=./target/classes/

# classes do projecto UMeR
CLASSES=Bike Car Client Company CustomProbabilisticDistribution \
	DeviationComparator Driver GUI Helicopter MoneyComparatorC \
	MoneyComparatorD RatingComparator Trip UMeR User Van Vehicle

# ficheiros de código fonte do projecto UMeR
SOURCES=$(foreach c,$(CLASSES),src/java/$c.java)

# classes compiladas do projecto UMeR
BYTES=$(foreach c,$(CLASSES),target/classes/$c.class)

RESOURCES=\
	images/admin_banner_small.png \
	images/check-mark_small.png \
	images/client_small.png \
	images/company_small.png \
	images/driver_small.png \
	images/logo_taxi_small.png \
	images/red-cross_small.png \
	images/umer_icon.png

### comandos

# targets para facilitar o uso do makefile
.PHONY : umer-compile umer-run clean

# compila o código fonte do projecto UMeR
umer-compile : $(BYTES) $(foreach r,$(RESOURCES),target/classes/$r) | target/classes

# executa o projecto UMeR
umer-run :
	java -cp '$(CLASSPATH)' GUI

### targets específicos

# compilação do código java
$(BYTES) : $(SOURCES) | target/classes
	javac  -cp '$(CLASSPATH)' -d target/classes $^

# imagens
target/classes/images/% : src/resources/images/% | target/classes/images
	cp $< $@

# directorias para compilação
target :
	mkdir -p $@
target/classes :
	mkdir -p $@
target/classes/images :
	mkdir -p $@

#
# ATS
#

### variáveis

ATS_CLASSPATH=./target/classes:./lib/antlr-runtime-4.7.1.jar:$(CLASSPATH)
ATS_CLASSPATH=./target/classes:./lib/antlr-runtime-4.7.1.jar:$(CLASSPATH)

# classes para o projecto de ATS
ATS_CLASSES=ATS
ATS_GENERATED_CLASSES=ATSLexer ATSParser

# ficheiros de código fonte para o projecto de ATS
ATS_SOURCES=$(foreach c,$(ATS_CLASSES),src/java/$c.java)
ATS_GENERATED_SOURCES=$(foreach c,$(ATS_GENERATED_CLASSES),target/generated-sources/$c.java)

# classes compiladas para o projecto de ATS
ATS_BYTES=$(foreach c,$(ATS_CLASSES),target/classes/$c.class) \
          $(foreach c,$(ATS_GENERATED_CLASSES),target/classes/$c.class)

ANTLR4=java -Xmx500M -jar tools/antlr-4.7.1-complete.jar -no-listener -no-visitor -Xexact-output-dir

### comandos

# targets para facilitar o uso do makefile
.PHONY : ats-gen ats-compile ats-run

# gera o código Java correspondente à gramática
ats-gen : $(ATS_GENERATED_SOURCES)

# compila o código fonte do projecto UMeR
ats-compile : umer-compile $(ATS_BYTES)

# executa o projecto UMeR
ats-run :
	java -cp '$(ATS_CLASSPATH)' ATS

### targets específicos

$(ATS_BYTES) : $(ATS_SOURCES) $(ATS_GENERATED_SOURCES)
	javac -cp '$(ATS_CLASSPATH)' -d target/classes $^

$(ATS_GENERATED_SOURCES) : src/antlr4/ATS.g4 | target/generated-sources
	$(ANTLR4) -o $(@D) -lib $(<D) $<

target/generated-sources :
	mkdir -p $@
