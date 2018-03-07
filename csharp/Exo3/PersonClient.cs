using System.IO;

namespace Soat.CleanCoders.Refactoring.Exo3
{
    public class PersonClient
    {
        public void Client1(TextWriter @out, Person person)
        {
            @out.Write(person.first);
            @out.Write(" ");
            if (!string.IsNullOrEmpty(person.middle))
            {
                @out.Write(person.middle);
                @out.Write(" ");
            }

            @out.Write(person.last);
        }

        public string Client2(Person person)
        {
            var result = person.last + ", " + person.first;
            if (!string.IsNullOrEmpty(person.middle))
            {
                result += " " + person.middle;
            }

            return result;
        }

        public void Client3(TextWriter @out, Person person)
        {
            @out.Write(person.last);
            @out.Write(", ");
            @out.Write(person.first);
            if (!string.IsNullOrEmpty(person.middle))
            {
                @out.Write(" ");
                @out.Write(person.middle);
            }
        }

        public string Client4(Person person)
        {
            return person.last + ", " + person.first + (string.IsNullOrEmpty(person.middle)
                                                            ? ""
                                                            : " " + person.middle);
        }
    }
}
