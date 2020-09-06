package pojos.room;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;


public class RoomPojo {

    private boolean accessible;
    private String description;
    private String[] features;

    private String image;

    @Min(1)
    @Max(999)
    @NotNull(message = "Phone should not be null")
    @NotBlank(message = "Phone should not be blank")
    private int roomNumber;

    @Min(0)
    @Max(999)
    private int roomPrice;

    @JsonProperty("roomid")
    private int roomId;

    @NotNull(message = "Type must be set")
    @Pattern(regexp ="Single|Double|Twin|Family|Suite", message = "Type can only contain the room options Single, Double, Twin, Family or Suite")
    private String type;

    public boolean isAccessible() {
        return accessible;
    }

    public RoomPojo setAccessible(boolean accessible) {
        this.accessible = accessible;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RoomPojo setDescription(String description) {
        this.description = description;
        return this;
    }

    public String[] getFeatures() {
        return features;
    }

    public RoomPojo setFeatures(String[] features) {
        this.features = features;
        return this;
    }

    public String getImage() {
        return image;
    }

    public RoomPojo setImage(String image) {
        this.image = image;
        return this;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomPojo setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public RoomPojo setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
        return this;
    }

    public int getRoomId() {
        return roomId;
    }

    public RoomPojo setRoomId(int roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getType() {
        return type;
    }

    public RoomPojo setType(String type) {
        this.type = type;
        return this;
    }
}
