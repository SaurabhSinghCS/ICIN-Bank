export interface User{
    id:number;
    first_name:string;
    last_name: string;
    user_name: string;
    dob:string;
    email: string;
    accno: BigInteger;
    blocked : Boolean;
    transfer_access:Boolean;
    validated:number;
}
