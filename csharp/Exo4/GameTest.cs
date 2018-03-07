using NFluent;
using Xunit;

namespace Soat.CleanCoders.Refactoring.Exo4
{
    public class GameTest
    {
        [Fact]
        public void TestDefaultMove()
        {
            var game = new Game("XOXOX-OXO");

            var result = game.Move('X');

            Check.That(result)
                 .IsEqualTo(5);

            game   = new Game("XOXOXOOX-");
            result = game.Move('O');

            Check.That(result)
                 .IsEqualTo(8);

            game   = new Game("---------");
            result = game.Move('X');

            Check.That(result)
                 .IsEqualTo(0);

            game   = new Game("XXXXXXXXX");
            result = game.Move('X');

            Check.That(result)
                 .IsEqualTo(-1);
        }

        [Fact]
        public void TestFindWinningMove()
        {
            var game = new Game("XO-XX-OOX");

            var result = game.Move('X');

            Check.That(result)
                 .IsEqualTo(5);
        }

        [Fact]
        public void TestWinConditions()
        {
            var game = new Game("---XXX---");

            var winner = game.Winner();

            Check.That(winner)
                 .IsEqualTo('X');
        }
    }
}
