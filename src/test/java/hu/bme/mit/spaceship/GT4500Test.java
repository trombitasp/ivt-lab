package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private  TorpedoStore mockTs1;
  private  TorpedoStore mockTs2;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    mockTs1 = mock(TorpedoStore.class);
    mockTs2 = mock(TorpedoStore.class);
    this.ship = new GT4500(mockTs1, mockTs2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTs1.fire(1)).thenReturn(true);
    when(mockTs2.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTs1.getTorpedoCount()).thenReturn(1);
    when(mockTs1.fire(1)).thenReturn(true);

    when(mockTs2.getTorpedoCount()).thenReturn(2);
    when(mockTs2.fire(2)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
