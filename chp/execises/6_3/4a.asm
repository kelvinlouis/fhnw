    MOV     CL,33
    MOV     AL,A0
    MOV     BL,E0
    
    MOV     DL,00
Loop:
    ADD     AL,DL
    MOV     [AL],CL
    SUB     AL,DL
    
    ADD     BL,DL
    MOV     [BL],CL
    SUB     BL,DL
    
    ADD     AL,10
    SUB     BL,10
    INC     DL
    CMP     DL,05
    JNZ     Loop
    
    END