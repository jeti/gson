package io.jeti.gson;

import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;

public class SerializeTest {

    @Test
    public void test() throws Exception {

        /* Fill the village with idiots. */
        int n = 4;
        List<Idiot> idiots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idiots.add(new Idiot("Name: " + i, "Nickname: " + i, i, i + 1));
        }

        /* Now create a village */
        Village village = new Village(idiots, new float[] { 1f, 2f, 3f, 4f });

        /*
         * Finally, try to serialize, and deserialize the village, then check
         * whether the deserialized object is equal to the original object.
         */
        GsonSerializer gsonSerializer = new GsonSerializer();
        String serialized = gsonSerializer.toString(village);
        Village dVillage = (Village) gsonSerializer.fromString(serialized);
        TestCase.assertEquals(village, dVillage);

        System.out.println("Serialized object: ");
        System.out.println(serialized);

        System.out.println("Original object: ");
        System.out.println(village.toString());

        System.out.println("Deserialized object: ");
        System.out.println(dVillage.toString());

        /*
         * Note that the deserialized object clearly won't be the same instance
         * as the original object. So if you are curious, you can uncomment the
         * following line just to show that it will fail.
         *
         * <pre><code>TestCase.assertEquals(village,dVillage);</code></pre>
         */
    }
}