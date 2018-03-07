using System.IO;
using NFluent;
using Xunit;

namespace Soat.CleanCoders.Refactoring.Exo3
{
    public class PersonClientTest
    {
        private readonly PersonClient _sut = new PersonClient();

        [Fact]
        public void Should_write_name_using_different_clients()
        {
            var bobSmith = new Person("Smith", "Bob", null);

            var @out = new StringWriter();
            _sut.Client1(@out, bobSmith);

            Check.That(@out.ToString())
                 .IsEqualTo("Bob Smith");
            Check.That(_sut.Client2(bobSmith))
                 .IsEqualTo("Smith, Bob");

            @out = new StringWriter();
            _sut.Client3(@out, bobSmith);
            Check.That(@out.ToString())
                 .IsEqualTo("Smith, Bob");

            Check.That(_sut.Client4(bobSmith))
                 .IsEqualTo("Smith, Bob");
        }

        [Fact]
        public void Should_write_the_name_using_differently()
        {
            var @out        = new StringWriter();
            var jennyJJones = new Person("Jones", "Jenny", "J");

            _sut.Client1(@out, jennyJJones);

            Check.That(@out.ToString())
                 .IsEqualTo("Jenny J Jones");
            Check.That(_sut.Client2(jennyJJones))
                 .IsEqualTo("Jones, Jenny J");
            @out = new StringWriter();
            _sut.Client3(@out, jennyJJones);

            Check.That(@out.ToString())
                 .IsEqualTo("Jones, Jenny J");

            Check.That(_sut.Client4(jennyJJones))
                 .IsEqualTo("Jones, Jenny J");
        }
    }
}
