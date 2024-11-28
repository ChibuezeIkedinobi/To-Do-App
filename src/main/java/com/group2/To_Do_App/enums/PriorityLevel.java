package com.group2.To_Do_App.enums;

import com.group2.To_Do_App.exception.customException.InvalidInputException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@AllArgsConstructor
public enum PriorityLevel {


        HIGH("high"),

        MEDIUM("medium"),

        LOW("low"),

        NONE("none");

        @Getter
        @Setter
        private String message;

        private static HashMap<String,PriorityLevel> priorityLevel = new HashMap<>();

        static {
                for (PriorityLevel priority : values()){
                        priorityLevel.put(priority.getMessage().toLowerCase(), priority);
                }
        }

        public static PriorityLevel getPriority(String priority){
                PriorityLevel priorityLevel1 = priorityLevel.get(priority.toLowerCase());
                if(priorityLevel1 != null) {
                        return priorityLevel1;
                }
                throw new InvalidInputException("The input is invalid");
        }
}
