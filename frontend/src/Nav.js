import { Link } from "react-router-dom";

export default function Nav() {
    return (
    <div>
        <Link to="/insert">INSERT</Link>
        <Link to="/selectall">GET STUDENTS</Link>
    </div>
    );
}
