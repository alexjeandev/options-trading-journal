import Header from "../components/Header.tsx";
import Hero from "../components/Hero.tsx";


function LandingPage() {
    return (
        <div className="bg-background min-h-screen text-text-primary font-sans">
            <Header />
            <Hero />
        </div>
    )
}
export default LandingPage;