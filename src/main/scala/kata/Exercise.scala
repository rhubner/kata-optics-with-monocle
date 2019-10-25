package kata

// The exercises will appear here



import monocle._
import monocle.macros._


case class Dog(age: Int, name: String)

case class Person(age: Int, pet: Dog)


object Gggg extends App {

  val cesar = Person(10, Dog(1, "azor"))

  val dogNameLens = GenLens[Dog](_.name)

  val personPetLens = GenLens[Person](_.pet)

  val dogNamePersonLens = personPetLens.composeLens(dogNameLens)


  val cesar2 =  cesar.copy( pet = cesar.pet.copy(name = "Rex"))

  val _cesra2 = dogNamePersonLens.set("Rex")(cesar)

  Console.println(cesar2)
  Console.println(_cesra2)


  val list = List(1,2,3)




  val secondFromList: Lens[List[Int], Int] = Lens[List[Int], Int](
    list => list(2))(set => list => list.head :: set :: list.tail.tail
  )

  Console.println(secondFromList.set(100)(list))


  val setAllSecondElementsTo100 = secondFromList.set(100)

  setAllSecondElementsTo100(list)
  setAllSecondElementsTo100(List(10,11111, 100))







  //val hairLens = Optional[Person, Int](_.hair)(_set => person => Person(person.age, Some(_set)))







}



