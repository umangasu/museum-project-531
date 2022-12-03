import { Button } from '@mui/material'
import PropTypes from 'prop-types'
import React, { Component } from 'react'
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import { Link } from "react-router-dom";
import QrCodeScannerRoundedIcon from '@mui/icons-material/QrCodeScannerRounded';


export class Homepage extends Component {

  render() {
    return (
      <div
        style={{
          textAlign: 'center'
        }}
      >
        <div
          style={{
            display: 'flex', 
            justifyContent: 'space-around',
            marginTop: '50px',
            alignItems: 'center',
            flexWrap: 'wrap'
          }}
        >
          <Card sx={{ maxWidth: 700, marginTop: '20px' }}>
              <CardMedia
                component="img"
                image="https://i.guim.co.uk/img/media/24b0e2a9f495c9844826afdffe46cafbf2b168f1/0_228_3500_2101/master/3500.jpg?width=620&quality=85&dpr=1&s=none"
                alt="green iguana"
              />
          </Card>
        </div>
        <div
          style={{
            marginTop: '50px'
          }}
        >
          <Link to="/artists/"> 
            <Button 
              variant="contained"
              style={{
                fontFamily: 'monospace',
                fontWeight: 700,
                letterSpacing: '.3rem',
                marginRight: '50px'
              }}
            >
              Artists
            </Button>
          </Link>
          <Link to="/artworks/"> 
            <Button 
              variant="contained"
              style={{
                fontFamily: 'monospace',
                fontWeight: 700,
                letterSpacing: '.3rem',
                marginRight: '50px'
              }}
            >
              Artworks
            </Button>
          </Link>
          <Link to={`/qrcodescanner/`} style={{textDecoration: 'none'}}>
              <Button 
                variant="contained"
                style={{
                  fontFamily: 'monospace',
                  fontWeight: 700,
                  letterSpacing: '.3rem',
                }}
              >
                <QrCodeScannerRoundedIcon sx={{ color: 'white' }}/>
              </Button>
          </Link>
        </div>
      </div>
    )
  }
}

export default Homepage