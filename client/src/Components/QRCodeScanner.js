import React, { useState, useEffect } from 'react'
import QrReader from 'react-qr-scanner'
import { useNavigate } from "react-router-dom";


function QRCodeScanner() {
  const [data, setData] = useState('No result');
  const history = useNavigate();
    useEffect(()=>{
        if(data==='No result') {
            return;
        }
        let link = data.split("/");
        let newlink = link[link.length - 2] + '/' + link[link.length - 1];
        history(`/${newlink}`);
    }, [data])

  return (
      <div style={{display: 'flex', width: '100%', alignItems: 'center', justifyContent: 'center', marginTop: '50px'}}>
      <QrReader
        onScan= {(result, error) => {
          if (!!result) {
            setData(result?.text);
          }

          if (!!error) {
            console.info(error);
          }
        }}
        />
      <p> {data}</p>
    </div>
  )
}

export default QRCodeScanner
