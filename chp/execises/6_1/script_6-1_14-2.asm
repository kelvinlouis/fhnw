;----------------------------------------
;   SKRIPT 6
;----------------------------------------

;   Exercise Page 14
Main:
    MOV AL,02   ; Value
    MOV BL,80   ; Address
    MOV CL,10   ; Counter

Loop:
    MOV [BL],AL ; Write Value to Address in RAM

    ADD AL,03   ; +3
    INC BL      ; Increment Address by 1
    DEC CL      ; Decrease Counter by 1
    
    JNZ Loop    ; Stop once counter is 0
    
    END
    