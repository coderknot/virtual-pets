import org.junit.*;
import static org.junit.Assert.*;

public class PersonTest {

  @Test
  public void person_instantiatesCorrectly_true() {
    Person testPerson = new Person("Harry", "harry@gmail.com");
    assertEquals(true, testPerson instanceof Person);
  }

  @Test
  public void person_instantiatesWithEmail_String() {
    Person testPerson = new Person("Harry", "harry@gmail.com");
    assertEquals("harry@gmail.com", testPerson.getEmail());
  }
}
