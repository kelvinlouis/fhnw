;
;   Exercises 6.1
;

; 8
    MOV     AL,20
    MOV     CL,05   ; length of HELLO

Loop:
    MOV     BL,[AL]
    ADD     BL,20
    MOV     [AL],BL
    INC     AL
    
    DEC     CL
    JNZ     Loop

; DATA
    ORG     20
    DB      "HELLO"

    END  