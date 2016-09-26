;----------------------------------------
;   Exercise 6.3
;----------------------------------------

;   2
    
    ORG 00      ;   S O Z (Nach Reset sind alle Flags zurückgesetzt)
    MOV BL,17   ;   0 0 0
    ADD BL,72   ;   1 1 0
    DEC BL      ;   1 0 0
    MOV CL,88   ;   1 0 0
    SUB BL,CL   ;   0 0 1


    END