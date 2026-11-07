
import { useState } from "react";
import { insert } from "./StudentService";
import { useNavigate } from "react-router-dom";

function StudentInsertion() {

  const navigate = useNavigate();

  const [student, setStudent] = useState({
    fName: "",
    lName: "",
    branch: "",
    age: 0,
    marks: 0,
    emailId: "",
    phnNo: 0,
  });

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const save = async () => {
    await insert (student);
    navigate("/selectall")
  }

  return (
    <div>
      <label>First Name</label><br />
      <input type="text" name="fName" placeholder="FirstName" onChange={handleChange} /><br /><br />
      <label>Last Name</label><br />
      <input type="text" name="lName" placeholder="LastName" onChange={handleChange} /><br /><br />
      <label>Branch</label><br />
      <input type="text" name="branch" placeholder="Branch" onChange={handleChange} /><br /><br />
      <label>Age</label><br />
      <input type="number" name="age" placeholder="Age" onChange={handleChange} /><br /><br />
      <label>Marks</label><br />
      <input type="number" name="marks" placeholder="Marks" onChange={handleChange} /><br /><br />
      <label>Email Id</label><br />
      <input type="email" name="emailId" placeholder="EmailId" onChange={handleChange} /><br /><br />
      <label>Phone Number</label><br />
      <input type="tel" name="phnNo" placeholder="PhoneNo" onChange={handleChange} /><br /><br />
      <input type="button" value="Submit" onClick = {save}/>
    </div>
  );
}

export default StudentInsertion;
