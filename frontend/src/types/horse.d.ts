export enum Gender {
    MALE = "MALE",
    FEMALE = "FEMALE",
    OTHER = "OTHER"
}

export interface Horse {
    id:         number
    firstName:  string
    lastName:   string
    email:      string
    picture:    string
    gender:     Gender
    birthday:   Date
    bodyHeight: number
    bodyLength: number
    city:       string
    country:    string
}
