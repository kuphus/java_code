/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w3d14;

/**
 *
 * @author e.turkesteen
 */
public class Kassa {
  private double subtotaal;
  private final double PERCENTAGE_BTW = 21.0;
  
  public Kassa() {
    subtotaal = 0;
  }
  
  public void telOp( double bedrag ) {
    subtotaal += bedrag;
  }
  
  public double getSubtotaal() {
    return subtotaal;
  }
  
  public void reset() {
    subtotaal = 0;
  }
  
  public double berekenBTW() {
    return subtotaal - berekenSubtotaalExBTW();
  }
  
  public double berekenSubtotaalExBTW() {
    return subtotaal / (1 + PERCENTAGE_BTW/100 );
  }
}
