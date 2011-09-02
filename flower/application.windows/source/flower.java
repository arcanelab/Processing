import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class flower extends PApplet {

int w = 1000;
int h = 625;

int halfw = w/2;
int halfh = h/2;

float PICONST = 2 * PI / 380;

public void setup()
{
  size(1000,625);
  background(0, 30, 0);
  smooth();
}

float d = 0.0f;

public void draw()
{
  float szirom = 10;//5+10*(mouseX/(float)w);
  float mouseXconst = (mouseX/(float)w);
  background(0);
  int i=0;
  while(i<380*4*mouseXconst)
  {
    float t = i*PICONST/4/mouseXconst;
    float sint = sin(t);
    float cost = cos(t);
    stroke(cos(t*1)*128+128,sin(t*3)*128+128,sin(t*2)*128+128,128);
    //stroke(0,g,0,128);
    
    float originx = halfw+sint*50;
    float originy = halfh+cost*50;
    float destx = halfw+sint*halfh*0.85f;
    float desty = halfh+cost*halfh*0.85f;
    
    float sziromConst = t*szirom+d;
    float finalx = destx + sin(sziromConst) * 40;
    float finaly = desty + cos(sziromConst) * 40;

    line(originx, originy, finalx, finaly);
    i++;
  } // while
  
  d += (mouseY/(float)h)*0.5f - 0.25f;
}
  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "flower" });
  }
}
