import java.io.EOFException;
import java.util.Random;

public class SimpleCharacterReader implements ICharacterReader {
	private int m_Pos = 0;

	public static final char lf = '\n';

	private String m_Content = "I am silver and exact. I have no preconceptions." +
	lf +
	"What ever you see I swallow immediately" + 
	lf +
	"Just as it is, unmisted by love or dislike." + 
	lf +
	"I am not cruel, only truthful" + 
	lf +
	"The eye of a little god, four-cornered" + 
	lf +
	"Most of the time I meditate on the opposite wall." + 
	lf +
	"It is pink, with speckles. I have looked at it so long" + 
	lf +
	"I think it is a part of my heart. But it flickers." + 
	lf +
	"Faces and darkness separate us over and over." + 
	lf +
	"Now I am a lake. A woman bends over me," + 
	lf +
	"Searching my reaches for what she really is." + 
	lf +
	"Then she turns to those liars, the candles or the moon." + 
	lf +
	"I see her back, and reflect it faithfully." + 
	lf +
	"She rewards me with tears and an agitation of hands." + 
	lf +
	"I am important to her. She comes and goes." + 
	lf +
	"Each morning it is her face that replaces the darkness." + 
	lf +
	"In me she has drowned a young girl, and in me an old woman"+
	lf +
	"Rises toward her day after day, like a terrible fish.";

	Random m_Rnd = new Random();

	public char GetNextChar() throws EOFException {

		if (m_Pos >= m_Content.length()) {
			throw new EOFException();
		}

		return m_Content.charAt(m_Pos++);

	}

	public void Dispose() {
		// do nothing
	}
}
