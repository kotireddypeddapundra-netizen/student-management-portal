
import { BrowserRouter as Router, Routes, Route} from "react-router-dom";
import StudentInsertion from "./InsertStudent";
import GetStudents from "./GetStudent";
import Nav from "./Nav";

function Routing() {
    return(
        <Router>
            <Nav />
            <Routes>
                <Route path="/" element={<GetStudents />}></Route>
                <Route path="/insert" element={<StudentInsertion />}></Route>
                <Route path="selectall" element={<GetStudents />}></Route>
            </Routes>
        </Router>
    )
}

export default Routing;