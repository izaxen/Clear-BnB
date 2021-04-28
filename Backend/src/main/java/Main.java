import express.Express;

import static nosqlite.Database.collection;

public class Main {

    public static void main(String[] args) {
        Express app = new Express();

        collection(op -> op.useBrowser = true);
        app.listen(4000);
    }

}
