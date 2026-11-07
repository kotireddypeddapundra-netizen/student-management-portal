import React,{ useEffect, useState } from "react";
import { getStudents } from "./StudentService";


function GetStudents(){

    const[student,setStudent] = useState([]);
    useEffect(()=>{
        loadData();
    },[]);

    const loadData = async () => {
        const result = await getStudents();
        setStudent(result.data)
    }
    return(
        <div>
            <h1>Get Students Component</h1>
            <table>
                <thead>
                <th>sid</th>
                <th>fName</th>
                <th>lname</th>
                <th>branch</th>
                <th>age</th>
                <th>marks</th>
                <th>emailId</th>
                <th>phnNo</th>
                </thead>
                <tbody>
                    {student.map(s => (
                        <tr key={s.sId || s.sid}>
                            <td>{s.sId ?? s.sid}</td>
                            <td>{s.fName}</td>
                            <td>{s.lName}</td>
                            <td>{s.branch}</td>
                            <td>{s.age}</td>
                            <td>{s.marks}</td>
                            <td>{s.emailId}</td>
                            <td>{s.phnNo}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default GetStudents;