Start:
    MOV     AL,11
    MOV     BL,22
    MOV     CL,33
    
    PUSH    AL
    PUSH    BL
    PUSH    CL

    MOV     AL,00
    MOV     BL,00
    MOV     CL,00

    POP     CL
    POP     BL
    POP     AL
    
    END