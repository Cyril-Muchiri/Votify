body {
            background-color: antiquewhite;
            font-family: Arial, sans-serif;
            display: flex;
            margin-top: 5%;
        }

        .main {
            display: grid;
            gap: 20px;
            max-width: 1200px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .card-container {
            display: flex;
            justify-content: space-evenly;
        }

        .logout-btn {
            background-color: #5f80b4;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
        }

        .logout-btn:hover {
            background-color: #4b6f9f;
        }

        .active-polls,
        .div {
            color: #fff;
            border-radius: 5px;
            padding: 10px 20px;
            text-align: center;
        }

        .active-polls .view-active,
        .div button {
            color: black;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

        .active-polls .view-active:hover,
        .div button:hover {
            background-color: #5f80b4;
            color: #fff;
        }

        .card {
            width: 200px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px;
            text-align: center;
            padding: 10px;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            display: inline-block;
        }

        .card img {
            border-radius: 50%;
            max-width: 100px;
            max-height: 100px;
            margin-bottom: 10px;
        }

        .card h2 {
            font-size: 1.2em;
            margin-bottom: 5px;
            color: #5f80b4;
        }

        .card p {
            color: #795548;
        }

        .vote-btn {
            width: 15vw;
            height: 10vh;
            background-color: #5f80b4;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            margin-top: 10px;
        }

        .vote-btn:hover {
            background-color: #4b6f9f;
        }

        .logout {
            display: flex;
            justify-content: right;
        }