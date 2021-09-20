package ws.synopsis.training.soap.consumer.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingResponse <T> {
    TrainingStatus status;
    private T data;

    public TrainingResponse(TrainingStatus status){
        this.setStatus(status);
    }

}
