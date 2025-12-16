package com.PetProject.petRest.Modells.DTO.ServiceDTO;

public class APIResponseDTO<T> {


        private boolean success;
        private T data;
        private ExceptionDTO error;

        private APIResponseDTO(boolean success, T data, ExceptionDTO error) {
            this.success = success;
            this.data = data;
            this.error = error;
        }

        public static <T> APIResponseDTO<T> success(T data) {
            return new APIResponseDTO<>(true, data, null);
        }

        public static APIResponseDTO<Void> success() {
            return new APIResponseDTO<>(true, null, null);
        }

        public static APIResponseDTO<Void> error(ExceptionDTO error) {
            return new APIResponseDTO<>(false, null, error);
        }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ExceptionDTO getError() {
        return error;
    }

    public void setError(ExceptionDTO error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


