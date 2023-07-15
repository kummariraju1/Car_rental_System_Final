
import React from 'react';

import {

  MDBFooter,

  MDBContainer,

  MDBIcon,

  MDBInput,

  MDBCol,

  MDBRow,

  MDBRipple

} from 'mdb-react-ui-kit';


export default function Footer() {

  return (

    <MDBFooter className='text-center text-white' style={{ backgroundColor: '#caced1' }}>

      <MDBContainer className='p-4'>

        <section className=''>

          <MDBRow>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/dba07750317521.58cd54d864ff0.jpg' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/b3d2a8153659483.6333ce167405b.jpg' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/5b2e5b127063933.Y3JvcCw5MjAsNzIwLDIwLDA.jpg' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/9cb07a171376985.Y3JvcCw0NjEwLDM2MDYsMzk5LDA.jpg' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/7720af104231203.Y3JvcCw0OTYxLDM4ODEsNjM4LDA.jpg' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

            <MDBCol lg='2' md='12' className='mb-4 mb-md-0'>

              <MDBRipple

                rippleColor='light'

                className='bg-image hover-overlay shadow-1-strong rounded'

              >

                <img src='https://mir-s3-cdn-cf.behance.net/projects/max_808_webp/883b74118497421.Y3JvcCwxMzgwLDEwODAsMjcwLDA.png' className='w-100' />

                <a href='#!'>

                  <div

                    className='mask'

                    style={{ backgroundColor: 'rgba(251, 251, 251, 0.2)' }}

                  ></div>

                </a>

              </MDBRipple>

            </MDBCol>

          </MDBRow>

        </section>

      </MDBContainer>

      <div className='text-center p-3' style={{ backgroundColor: 'rgba(0, 0, 0, 2)' }}>

        © 2023 Copyright:

        <a className='text-white' href='/login'>

          Car Rentals Hyderabad

        </a>

      </div>

    </MDBFooter>

  );

}