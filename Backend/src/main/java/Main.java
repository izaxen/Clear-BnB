import express.Express;
import models.Authorization;
import models.BookingReceipt;
import models.RentalObject;
import models.User;

import java.util.List;

import static nosqlite.Database.collection;


public class Main {

    public static void main(String[] args) {
        Express app = new Express();

        collection(op -> op.useBrowser = true);

        new Authorization(app);

        //User
//        app.get("/rest/users", (req, res) -> {
//           List<User> users = collection("User").find();
//           res.json(users);
//        });

        app.get("/rest/users/:id", (req, res) -> {
            String id = req.params("id");
            User user = collection("User").findById(id);
            res.json(user);
        });

        app.post("/rest/users", (req, res) -> {
           User user = req.body(User.class);
           collection("User").save(user);
           res.json(user);
        });

        app.delete("/rest/users/:id", (req, res) -> {
           String id = req.params("id");
           collection("User").deleteById(id);
           res.send("Deleted");
        });

        //RentalHouse

        app.get("/rest/rental-objects", (req, res) -> {
           List<RentalObject> rentalObjects = collection("RentalObject").find();
           res.json(rentalObjects);
        });


        app.get("/rest/rental-objects/:id", (req, res) -> {
            String id = req.params("id");
            RentalObject rentalObject = collection("RentalObject").findById(id);
            res.json(rentalObject);
        });

        app.post("/rest/rental-objects", (req, res) -> {
            RentalObject rentalObject = req.body(RentalObject.class);
            collection("RentalObject").save(rentalObject);
            res.json(rentalObject);
        });

        app.delete("/rest/rental-objects/:id", (req, res) -> {
            String id = req.params("id");
            collection("RentalObject").deleteById(id);
            res.send("Deleted");
        });

        //BookingReceipt
        app.get("/rest/booking-receipts", (req, res) -> {
            List<BookingReceipt> bookingReceipt = collection("BookingReceipt").find();
            res.json(bookingReceipt);
        });


        app.get("/rest/booking-receipts/:id", (req, res) -> {
            String id = req.params("id");
            BookingReceipt bookingReceipt = collection("bookingReceipt").findById(id);
            res.json(bookingReceipt);
        });

        app.post("/rest/booking-receipts", (req, res) -> {
            BookingReceipt bookingReceipt = req.body(BookingReceipt.class);
            collection("BookingReceipt").save(bookingReceipt);
            res.json(bookingReceipt);
        });

        app.delete("/rest/booking-receipts/:id", (req, res) -> {
            String id = req.params("id");
            collection("BookingReceipt").deleteById(id);
            res.send("Deleted");
        });




        app.listen(4000);

    }
}
