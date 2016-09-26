;
;   Exercises 6.1
;

; 13 (Comment produced machine code)
    ORG 22
Repeat:
    MOV     AL,BL       ; [22] D5 00 01
    SHL     AL          ; [25] 9C 00
    MOV     [DL],AL     ; [27] D4 03 00
    INC     DL          ; [2A] A4 03
    DEC     BL          ; [2C] A5 01
    JNZ     Repeat      ; [2E] C2 F4
    
    END