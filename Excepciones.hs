testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

result :: Int -> Int
result x | x > 5 = 4
         | otherwise = error "hey"

-- ahora pueden evaluar
t = [ testF (result 3 ),
      testF (result 8 ) ]