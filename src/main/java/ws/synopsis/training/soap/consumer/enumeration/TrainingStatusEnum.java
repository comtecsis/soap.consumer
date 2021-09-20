package ws.synopsis.training.soap.consumer.enumeration;

import lombok.Getter;
import ws.synopsis.training.soap.consumer.response.TrainingResponse;
import ws.synopsis.training.soap.consumer.response.TrainingStatus;

@Getter
public enum TrainingStatusEnum {

    OK("0000", "Ejecutado exitosamente.")
    , ERROR_GENERIC("9000", "Error inesperado.")
    , ERROR_CLIENT_EXIST("9001", "Cliente ya esta registrado.")
    , ERROR_CLIENT_NOT_EXIST("9002", "Cliente no esta registrado.");

    private final TrainingStatus status;

    TrainingStatusEnum(String code, String msg) {
        this.status = new TrainingStatus(code, msg);
    }

    public <T> TrainingResponse<T> createResponse(Class<T> clazz){
        return new TrainingResponse<T>(getStatus());
    }

}
