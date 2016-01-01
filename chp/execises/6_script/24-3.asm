Start:
    POP     AL      ; STACK UNDERFLOW
    POP     BL
    POP     CL
    POP     DL

    ADD     AL,BL

Prim:
    ORG     C0
    DB      01
    DB      02
    DB      03
    DB      05
    DB      07


    END