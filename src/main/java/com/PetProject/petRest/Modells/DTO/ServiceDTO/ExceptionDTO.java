package com.PetProject.petRest.Modells.DTO.ServiceDTO;

import java.time.Instant;

public class ExceptionDTO {

        private String code;
        private String message;
        private Instant timestamp;

        public ExceptionDTO(String code, String message) {
            this.code = code;
            this.message = message;
            this.timestamp = Instant.now();
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public Instant getTimestamp() {
            return timestamp;
        }


}
