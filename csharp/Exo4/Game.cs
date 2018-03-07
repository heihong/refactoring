//========================================================================
// This conversion was produced by the Free Edition of
// Java to C# Converter courtesy of Tangible Software Solutions.
// Order the Premium Edition at https://www.tangiblesoftwaresolutions.com
//========================================================================

using System.Text;

namespace Soat.CleanCoders.Refactoring.Exo4
{
	public class Game
	{

		public StringBuilder board;

		public Game(string s)
		{
			board = new StringBuilder(s);
		}

		private Game(StringBuilder s, int position, char player)
		{
			board = new StringBuilder(s);
			board.Append(s);
			board[position] = player;
		}

		public virtual int move(char player)
		{
			for (int i = 0; i < 9; i++)
			{
				if (board[i] == '-')
				{
					Game game = play(i, player);
					if (game.winner() == player)
					{
						return i;
					}
				}
			}

			for (int i = 0; i < 9; i++)
			{
				if (board[i] == '-')
				{
					return i;
				}
			}
			return -1;
		}

		public virtual char winner()
		{
			if (board[0] != '-' && board[0] == board[1] && board[1] == board[2])
			{
				return board[0];
			}

			if (board[3] != '-' && board[3] == board[4] && board[4] == board[5])
			{
				return board[3];
			}

			if (board[6] != '-' && board[6] == board[7] && board[7] == board[8])
			{
				return board[6];
			}

			return '-';
		}

		private Game play(int i, char player)
		{
			return new Game(this.board, i, player);
		}
	}

}