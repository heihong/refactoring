using System.Text;

namespace Soat.CleanCoders.Refactoring.Exo4
{
    public class Game
    {
        public StringBuilder Board { get; }

        public Game(string s)
        {
            Board = new StringBuilder(s);
        }

        private Game(StringBuilder s, int position, char player)
        {
            Board = new StringBuilder(s.ToString()) { [position] = player };
        }

        public int Move(char player)
        {
            for (var i = 0; i < 9; i++)
            {
                if (Board[i] == '-')
                {
                    var game = Play(i, player);
                    if (game.Winner() == player)
                    {
                        return i;
                    }
                }
            }

            for (var i = 0; i < 9; i++)
            {
                if (Board[i] == '-')
                {
                    return i;
                }
            }

            return -1;
        }

        public char Winner()
        {
            if (Board[0] != '-'
                && Board[0] == Board[1]
                && Board[1] == Board[2])
            {
                return Board[0];
            }

            if (Board[3] != '-'
                && Board[3] == Board[4]
                && Board[4] == Board[5])
            {
                return Board[3];
            }

            if (Board[6] != '-'
                && Board[6] == Board[7]
                && Board[7] == Board[8])
            {
                return Board[6];
            }

            return '-';
        }

        private Game Play(int i, char player)
        {
            return new Game(Board, i, player);
        }
    }
}
