import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

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

  @Test
  public void equals_returnsTrueIfNameAndEmailAreSame_True() {
    Person firstPerson = new Person("Harry", "harry@gmail.com");
    Person secondPerson = new Person("Harry", "harry@gmail.com");
    assertTrue(firstPerson.equals(secondPerson));
  }

  @Test
  public void save_insertsObjectIntoDatabase_Person() {
    Person testPerson = new Person("Harry", "harry@gmail.com");
    testPerson.save();
    assertTrue(Person.all().get(0).equals(testPerson));
  }

  @Rule
    public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_returnsAllInstancesOfPerson_true() {
    Person firstPerson = new Person("Harry", "harry@gmail.com");
    firstPerson.save();
    Person secondPerson = new Person("Ron", "ron@gmail.com");
    secondPerson.save();
    assertEquals(true, Person.all().get(0).equals(firstPerson));
    assertEquals(true, Person.all().get(1).equals(secondPerson));
  }

  @Test
  public void save_assignsIdToObject() {
    Person testPerson = new Person("Harry", "harry@gmail.com");
    testPerson.save();
    Person savedPerson = Person.all().get(0);
    assertEquals(testPerson.getId(), savedPerson.getId());
  }

  @Test
  public void find_returnsPersonWithSameId_secondPerson() {
    Person firstPerson = new Person("Harry", "harry@gmail.com");
    firstPerson.save();
    Person secondPerson = new Person("Ron", "ron@gmail.com");
    secondPerson.save();
    assertEquals(Person.find(secondPerson.getId()), secondPerson);
  }

}
