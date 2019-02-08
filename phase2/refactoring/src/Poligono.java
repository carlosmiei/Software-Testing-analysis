
/**
 * Write a description of class Poligono here.
 * 
 * @author João Saraiva
 * @version 6/2018
 */



import java.util.List;
import java.util.ArrayList;

public abstract class Poligono
{
    private List<Ponto> poligono;
    
    public Poligono()
    { this.poligono = new ArrayList<>();
    }
    
    public Poligono(List<Ponto> pol)
    {  this();
       for (Ponto p : pol)
         this.poligono.add(p.clone());
       this.poligono.add(pol.get(0).clone());
    }


    public List<Ponto> getPoligono()
    { List<Ponto> pts = new ArrayList<>();
      for (Ponto p : this.poligono)
        pts.add(p.clone());
      return pts;
    }

    public void setPoligono(List<Ponto> pts)
    { this.poligono = new ArrayList<>();
      for (Ponto p : pts)
        this.poligono.add(p.clone());
    }
    
    
    public void addPonto(Ponto p)
    { this.poligono.add(p.clone()); }
    
    public boolean fechada()
    { return this.poligono.get(0).equals(this.poligono.get(this.poligono.size()-1));
    }
    
    public double perimetro()
    { double res = 0;
      for (int i = 1 ; i < this.poligono.size() ; i++)
        res += this.poligono.get(i).distancia(this.poligono.get(i-1));
      return res;
    }
    
       
/*
codigo re-utilizado de 

https://stackoverflow.com/questions/471962/how-do-i-efficiently-determine-if-a-polygon-is-convex-non-convex-or-complex


The algorithm is guaranteed to work as long as the vertices are ordered (either clockwise or counter-clockwise), 
and you don't have self-intersecting edges (i.e. it only works for simple polygons)
*/

    public boolean eConvexo()
    {  
       if (this.poligono.size() < 4)     // Triangulo é sempre convexo
            return true;

       boolean sign = false;
       int n = this.poligono.size();
        boolean result = false;
        int i = 0;
        while (i < n) {
            double dx1 = getDx1(n, i, (i + 2) % n);
            double dy1 = getDy1(n, i, (i + 2) % n);
            double dx2 = getDx1(n, i, i);
            double dy2 = getDy1(n, i, i);
            double zcrossproduct = getZcrossproduct(dx1, dy1, dx2, dy2);

            if (i == 0)
                   sign = zcrossproduct > 0;
           else {
                   if (sign != (zcrossproduct > 0))
                    result= false;
                }
            i++;
        }


        if (result) return true;
            return false;
    }

    private double getZcrossproduct(double dx1, double dy1, double dx2, double dy2) {
        return dx1 * dy2 - dy1 * dx2;
    }

    private double getDy1(int n, int i, int i2) {
        return poligono.get(i2).getY() - poligono.get((i + 1) % n).getY();
    }

    private double getDx1(int n, int i, int i2) {
        return poligono.get(i2).getX() - poligono.get((i + 1) % n).getX();
    }


    public abstract double area();
       
    public abstract Poligono clone();
    
}
