package w1d1;


public class Tijdstip {
  // Attributen
  private int uur;
  private int minuut;
  private int seconde;
  
  // Constructor
  public Tijdstip( int uur, int minuut, int seconde ) {
  	this.uur = uur;
  	this.minuut = minuut;
  	this.seconde = seconde;
  }
 
  // Getters
  public int getUur() {
    return uur;
  }

  public int getMinuut() {
    return minuut;
  }

  public int getSeconde() {
    return seconde;
  }
    
  // Setters
  public void setUur( int uur ) {
    this.uur = uur;
  }

  public void setMinuut( int minuut ) {
    this.minuut = minuut;
  }

  public void setSeconde( int seconde ) {
    this.seconde = seconde;
  }
  
  // Andere methoden
  public void volgendUur() {
  	uur++;
  	if( uur == 24 )
  	  uur = 0;
  }

  public void volgendeMinuut() {
  	minuut++;
  	if( minuut == 60 ) {
  		minuut = 0;
  		volgendUur();
  	}
  }

  public void volgendeSeconde() {
  	seconde++;
  	if( seconde == 60 ) {
  		seconde = 0;
  		volgendeMinuut();
  	}
  }
  
  public String toString() {
  	return String.format( "%02d:%02d:%02d", getUur(), getMinuut(), getSeconde() );
  }
}
