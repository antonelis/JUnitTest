package data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonRegisterTest {

   @Test
    public void searchForPersonInListReturnsThatPerson(){
       PersonRegister personRegister = new PersonRegister();
       personRegister.addPerson(new Person("Anton",31));
       personRegister.addPerson(new Person("Colin",10));
       assertEquals(new Person("Anton",31),personRegister.searchPerson("Anton"));
   }
}