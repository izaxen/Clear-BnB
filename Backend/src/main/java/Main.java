import express.Express;
import io.javalin.core.util.FileUtil;
import io.javalin.http.UploadedFile;
import models.*;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static nosqlite.Database.collection;
import static nosqlite.utilities.Filter.*;

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


        app.put("/rest/users/:id", (req, res) -> {
            String id = req.params("id");
        Map<String, List<String>> querySet = req.query();

        for (Map.Entry<String, List<String>> entry : querySet.entrySet()) {
            collection("User").updateFieldById(id, entry.getKey(), entry.getValue().get(0));
        }
        User user = collection("User").findById(id);
        res.json(user);
        });

        app.post("/rest/updateUser/:id", (req, res) -> {
           String id = req.params("id");
           User user = req.body(User.class);
            collection("User").save(user);
           //User user = collection("User").updateFieldById();
        });

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
            String limitQuery = req.query("limit");
            if (limitQuery != null) {
                int limit = Integer.parseInt(req.query("limit"));
                List<RentalObject> rentalObjects = collection("RentalObject").find(op -> {
                    op.limit = limit;
                });
                res.json(rentalObjects);
            } else {
                List<RentalObject> rentalObjects = collection("RentalObject").find();
                res.json(rentalObjects);
            }
        });
        app.get("/rest/rental-objects/:id", (req, res) -> {
            String id = req.params("id");
            RentalObject rentalObject = collection("RentalObject").findById(id);
            res.json(rentalObject);
        });
        app.get("/rest/rental-objects/filter/:filter", (req, res) -> {
            // Find all bookingReceipts for each of the objects in the result
            // And remove object if all dates in the available period have been taken already
            try {
                String search = "";
                Map<String, List<String>> querySet = req.query();
                if (querySet.containsKey("search")) {
                    search = querySet.get("search").get(0);
                    querySet.remove("search");
                }
                String queryString = querySet.entrySet().stream().map(e ->
                        e.getKey() + "=" + e.getValue().get(0)).collect(Collectors.joining("&&"));
                List<RentalObject> searched;
                if (!search.equals("")) {
                    searched = collection("RentalObject").find(or(
                            text("address", "%" + search + "%"),
                            text("description", "%" + search + "%"),
                            text("freeText", "%" + search + "%")
                    ));
                    List<RentalObject> filtered = collection("RentalObject").find(queryString);
                    List<RentalObject> finalList = new ArrayList<>();
                    for (RentalObject rental : searched) {
                        for (RentalObject r : filtered) {
                            if (rental.getId().equals(r.getId())) {
                                finalList.add(rental);
                            }
                        }
                    }
                    searched = finalList;
                } else {
                    searched = collection("RentalObject").find(queryString);
                }
                res.json(searched);
            } catch (Exception e) {
                System.out.println(e);
                res.status(400);
            }
        });
        app.get("/rest/rental-objects/cities/find", (req, res) -> {
            List<RentalObject> cities = collection("RentalObject").find();
            List<String> objects = new ArrayList<>();
            cities.forEach((c) -> {
                if (!objects.contains(c.getCity())) {
                    objects.add(c.getCity());
                }
            });
            res.json(objects);
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
        app.get("/rest/rental-objects/user/:id", (req, res) -> {
            String id = req.params("id");
            List<RentalObject> list = collection("RentalObject").find(eq("userId", id));
            res.json(list);
        });
        //BookingReceipt
        app.get("/rest/booking-receipts", (req, res) -> {
            List<BookingReceipt> bookingReceipts = collection("BookingReceipt").find();
            res.json(bookingReceipts);
        });
        app.get("/rest/booking-receipts/:id/", (req, res) -> {
            String id = req.params("id");
            BookingReceipt bookingReceipt = collection("BookingReceipt").findById(id);
            res.json(bookingReceipt);
        });
        app.get("/rest/booking-receipts/user/:id", (req, res) -> {
            String id = req.params("id");
            List<BookingReceipt> bookingReceipt = collection("BookingReceipt").find(eq("userId", id));
            res.json(bookingReceipt);
        });
        app.get("/rest/booking-receipts/filter/:id/", (req, res) -> {
            String id = req.params("id");
            try {
                List<BookingReceipt> bookingReceipts = collection("BookingReceipt").find(eq("rentalObjectId", id));
                res.json(bookingReceipts);
            } catch (Exception e) {
                System.out.println(e);
                res.send("fel");
            }
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
            List<Amenity> amenities = collection("Amenity").find();
            res.json(amenities);
        });
        app.get("/rest/amenities/:id", (req, res) -> {
            String id = req.params("id");
            Amenity amenity = collection("Amenity").findById(id);
            res.json(amenity);
        });
        app.post("/rest/amenities", (req, res) -> {
            Amenity amenity = req.body(Amenity.class);
            collection("Amenity").save(amenity);
            res.json(amenity);
        });
        app.delete("/rest/amenities/:id", (req, res) -> {
            String id = req.params("id");
            collection("Amenity").deleteById(id);
            res.send("OK");
        });
        app.post("/api/uploads/:id", (req, res) -> { //Uploading files
            String id = req.params("id");
            List<UploadedFile> files = req.formDataFiles("files");
            for (UploadedFile file : files) {
                FileUtil.streamToFile(file.getContent(), "src/Static/uploads/" + id + "/" + file.getFilename());
            }
            res.send("OK");
        });
        app.get("/api/uploads/:id", (req, res) -> {
                    String id = req.params("id");
                    String[] fileNames;
                    File f = new File("src/Static/uploads/" + id + "/");
                    fileNames = f.list();
                    if (fileNames == null) {
                        fileNames = new String[6];
                        for (int i = 0; i < 6; i++) {
                            fileNames[i] = "https://www.skistar.com/sv/boka-online/accommodation/Image/Get?imageId=129416&ImageSize=7&keepRatio=false";
                        }
                    } else {
                        for (int i = 0; i < fileNames.length; i++) {
                            fileNames[i] = "/uploads/" + id + "/" + fileNames[i];
                        }
                    }
                    res.json(fileNames);
                }
        );
        app.useStatic(Paths.get("src/Static"));
        app.listen(4000);
    }

}
