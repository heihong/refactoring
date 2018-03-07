namespace Soat.CleanCoders.Refactoring.Exo3
{
    public class Person
    {
        public string last { get; }
        public string first { get; }
        public string middle { get; }

        public Person(string last, string first, string middle)
        {
            this.last   = last;
            this.first  = first;
            this.middle = middle;
        }
    }
}
