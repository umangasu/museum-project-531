import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Homepage from './Components/Homepage';
import Artist from './Components/Artist';
import Artwork from './Components/Artwork';
import Exhibition from './Components/Exhibition';
import Navbar from './Components/Navbar';
import QRCodeScanner from './Components/QRCodeScanner';
import ArtistDetail from './Components/ArtistDetail';
import ArtworkDetail from './Components/ArtworkDetail';
import ExhibitionDetail from './Components/ExhibitionDetail';

function App() {
  return (
    <Router>
      <div>
          <Navbar/>
          <Routes>
            <Route path="/" exact element={<Homepage/>}/>
            <Route path="/artists/" exact element={<Artist/>}/>
            <Route path="/artworks/" exact element={<Artwork/>}/>
            <Route path="/exhibitions/" exact element={<Exhibition/>}/>
            <Route path="/qrcodescanner/" exact element={<QRCodeScanner/>}/>
            <Route path="/artists/:artistId" exact element={<ArtistDetail/>}/>
            <Route path="/artworks/:artworkId" exact element={<ArtworkDetail/>}/>
            <Route path="/exhibitions/:exhibitionId" exact element={<ExhibitionDetail/>}/>
            {/* <Route path="/users" exact component={UserList}/>
            <Route path="/users/:userId" exact component={UserDetail}/>
            <Route path="/users/:userId/album/:albumId" exact component={AlbumDetail}/> */}
          </Routes>
      </div>
    </Router>
  );
}

export default App;
