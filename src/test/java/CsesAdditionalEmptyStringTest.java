import org.junit.jupiter.api.Test;
import util.AcmTest;

public class CsesAdditionalEmptyStringTest extends AcmTest {
    @Override
    public void processInput() throws Exception {
        new CsesAdditionalEmptyString().solve();
    }

    @Test
    public void trivial1() {
        compare("aa", "1");
    }

    @Test
    public void trivial2() {
        compare("aabb", "2");
    }

    @Test
    public void sample() {
        compare("aabccb", "3");
    }

    @Test
    public void aaa500() {
        compare("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "107842769");
    }

    @Test
    public void something500_1() {
        compare("ppffbboohhllhhssiiqqppffkkbbhhqqddppyyxxzzeecckkoommrriiaawwlleebbbbiieellwwxxttaarrttwwmmvvzzyybbiiggqqzzjjhhzzfflljjggggzzggoojjggmmvvjjiiddeeyymmeeqqjjttrrwwxxjjuujjxxrrttkkrrdduuggaaddyyttxxbbmmppmmooccjjnngguurrkkxxiieeppuujjqqhhffrrxxffeellttrrttffttiirrppxxnnddttssbbggggyymmzzwwwwmmzzkksskkaammoottvvmmxxssuuddwwttggaassttrrbbuuxxmmffiiiiyyhhzzjjxxggrrccnnvvxxccooppookkjjwwzzttvvzzaaoovvppjjggxxoowwkkzzuussjjeeddzzbbbbppaaccccmmuurrddvveeyykkllooyyssqqjjzziiwwcczzjjaayyggggwwxxuubbhhaabbrr", "835363799");
    }
}
