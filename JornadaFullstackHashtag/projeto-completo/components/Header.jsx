import logoSpotify from "../assets/logo/spotify-logo.png";
import { Link } from "react-router-dom";

const Header = () => {
  return (
    <>
      <div className="header">
        <div className="header__logo">
          <Link to="/">
            <img src={logoSpotify} alt="Logo Spotify" />
          </Link>
        </div>
        <div className="header__title">
          <Link to="/">
            <h1>Spotify</h1>
          </Link>
        </div>
      </div>
    </>
  );
};

export default Header;
