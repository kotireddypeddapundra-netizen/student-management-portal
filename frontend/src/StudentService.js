
import axios from "axios";

const path = "http://localhost:9998/student";

export const insert = (student) => {
    return axios.post(`${path}/insert`, student);
};

export const getStudents = () => {
    return axios.get(`${path}/selectall`);
};

export const retrieveById = (sId) => {
    return axios.get(`${path}/selectbyid/${sId}`);
};

export const update = (sId, student) => {
    return axios.put(`${path}/update/${sId}`, student);
};

export const deleteStudent = (sId) => {
    return axios.delete(`${path}/delete/${sId}`);
};
