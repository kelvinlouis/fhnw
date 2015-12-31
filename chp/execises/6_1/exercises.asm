;
;   Exercises 6.1
;
    JMP     Ex8
; 1
Ex1:
    INC     BL      ; more readable
    ADD     BL,01   ; probably faster (immediate)

; 2 (unsigned no negative numbers)
;   MOV     AL,71
;   SUB     AL,06
;   ADD     AL,BL
;
; BL can be maximum 154 (9A)

; 3 (byte[] arr = {0x57, 0x6A}
Ex3:
    MOV AL,57
    MOV BL,6A
    MOV CL,A0
    
    MOV [CL],AL
    INC CL
    MOV [CL],BL

; 4 (SR O-Flag = 1)
Ex4:
    MOV AL,7F
    INC AL

; 5 (SR?)
Ex5:
    MOV AL,05
    SUB AL,AL   ; 0000'0010

; 6 (Check if AL is negative)
Ex6:
    MOV AL,7F
    AND AL,AL ;SIGNED FLAG = 1 if negative    

    END