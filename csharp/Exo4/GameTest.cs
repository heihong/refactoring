//========================================================================
// This conversion was produced by the Free Edition of
// Java to C# Converter courtesy of Tangible Software Solutions.
// Order the Premium Edition at https://www.tangiblesoftwaresolutions.com
//========================================================================

namespace Soat.CleanCoders.Refactoring.Exo4
{
	public class GameTest
	{

//JAVA TO C# CONVERTER TODO TASK: Most Java annotations will not have direct .NET equivalent attributes:
//ORIGINAL LINE: @Test public void testDefaultMove()
		public virtual void testDefaultMove()
		{
			Game game = new Game("XOXOX-OXO");

			int result = game.move('X');

			Assertions.assertThat(result).isEqualTo(5);

			game = new Game("XOXOXOOX-");
			result = game.move('O');

			Assertions.assertThat(result).isEqualTo(8);

			game = new Game("---------");
			result = game.move('X');

			Assertions.assertThat(result).isEqualTo(0);

			game = new Game("XXXXXXXXX");
			result = game.move('X');

			Assertions.assertThat(result).isEqualTo(-1);
		}


//JAVA TO C# CONVERTER TODO TASK: Most Java annotations will not have direct .NET equivalent attributes:
//ORIGINAL LINE: @Test public void testFindWinningMove()
		public virtual void testFindWinningMove()
		{
			Game game = new Game("XO-XX-OOX");

			int result = game.move('X');

			Assertions.assertThat(result).isEqualTo(5);
		}

//JAVA TO C# CONVERTER TODO TASK: Most Java annotations will not have direct .NET equivalent attributes:
//ORIGINAL LINE: @Test public void testWinConditions()
		public virtual void testWinConditions()
		{
			Game game = new Game("---XXX---");

			char winner = game.winner();

			Assertions.assertThat(winner).isEqualTo('X');
		}
	}
}