Start:
    MOV     AL,11
    MOV     BL,22
    MOV     CL,33
    
    PUSH    AL
    PUSH    BL
    PUSH    CL

    CALL    B0

    HALT

    ORG     B0
    MOV     AL,10
    MOV     BL,21
    MOV     CL,32
    
    ADD     BL,CL
    ADD     AL,BL       ; ILLEGAL OPCODE! (STACK HAS OVERWRITTEN SUBROUTINE)
    MOV     [32],AL
    SUB     BL,CL
    MOV     [33],BL

    END