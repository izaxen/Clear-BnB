import express.Express;
import io.javalin.core.util.FileUtil;
import io.javalin.http.UploadedFile;
import models.*;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.eq;

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
           res.send("OK");
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
            res.send("OK");
        });


        //BookingReceipt

        app.get("/rest/booking-receipts", (req, res) -> {
            List<BookingReceipt> bookingReceipts = collection("BookingReceipt").find();
            res.json(bookingReceipts);
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
            res.send("OK");
        });

        // Amenity

        app.get("/rest/amenities", (req, res) -> {
            List<Amenity>amenities = collection("Amenity").find();
            res.json(amenities);
        });

        app.get("/rest/amenities/:id", (req, res) -> {
            String id = req.params("id");
            Amenity amenity = collection("Amenity").findById(id);
            res.json(amenity);
        });

        app.post("/rest/amenities", (req,res) -> {
            Amenity amenity = req.body(Amenity.class);
            collection("Amenity").save(amenity);
            res.json(amenity);
        });

        app.delete("/rest/amenities/:id", (req,res) -> {
            String id = req.params("id");
            collection("Amenity").deleteById(id);
            res.send("OK");
        });

        app.post("/api/uploads/:id", (req, res) -> { //Uploading files
            String id = req.params("id");

            List<UploadedFile> files = req.formDataFiles("files");

            for(UploadedFile file : files){
                FileUtil.streamToFile(file.getContent(), "src/Static/uploads/"+id+"/" + file.getFilename());}

            res.send("OK");

        });

        app.get("/api/uploads/:id", (req, res) -> {
            String id = req.params("id");
            String[] fileNames;

            File f = new File("src/Static/uploads/"+id+"/");

            fileNames = f.list();

            for (int i = 0; i< fileNames.length; i++) {
                fileNames[i]= "http://localhost:4000/uploads/" + id + "/"+fileNames[i];
                }
            System.out.println("filenames" + fileNames);
            res.json(fileNames);

           // Amenity amenity = collection("Amenity").findById(id);
           // res.json();
        });

        app.useStatic(Paths.get("src/Static"));



        app.listen(4000);

    }
}
